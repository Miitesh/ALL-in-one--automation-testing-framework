package ccm;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;


public class SOAPTest {
	
	public static String SOAPAction = "\"http://soap.sforce.com/schemas/class/CaseAPI/CaseAPIPortType/createCaseRequest\"";
    
	public static String requestType = "POST";
	public static HashMap headermap = new HashMap<Object, Object>();
	public static String reqBody;
	public Response response=null;
	public String xml="";
	public XmlPath xmlPath;
	public static String url="https://cs37.salesforce.com/services/Soap/class/CaseAPI";
	public static String sessionId;
	public static String CaseNumber;
	public static String filename="CaseAPI/CreateCase.xml";
	public static String responseBody;
	
	
	public static String generateStringFromResource(String path)throws IOException {

	    return new String(Files.readAllBytes(Paths.get(path)));

	}
	public void setHeader(String header, String value)
	{
		this.headermap.put(header, value);
	}
	public  void setSession_id(String session)
	{
		this.sessionId=session;
	}
	public void setRequestType(String requestType)
	{
		this.requestType=requestType;
	}
	public void setSOAPAction(String value)
	{
		this.SOAPAction=value;
	}
	public void setFilename(String filename)
	{
		this.filename=filename;
	}
	public String getFilename()
	{
		return filename;
	}
	public void setUrl(String url)
	{
		this.url=url;
	}
	public String getCaseNumber()
	{
		return CaseNumber;
	}
	public void setCaseNumber(String casnum)
	{
		this.CaseNumber=casnum;
	}
	public String getresponseBody()
	{
		return responseBody;
	}
	public static void printAttributesInfo(Node root)
	{
	    NamedNodeMap attributes = root.getAttributes();
	    if (attributes != null)
	    {
	        for (int i = 0; i < attributes.getLength(); i++)
	        {
	            Node node = attributes.item(i);
	            if (node.getNodeType() == Node.ATTRIBUTE_NODE)
	            {
	                String name = node.getLocalName();//.getPrefix();
	                System.out.println(name + " " + node.getNamespaceURI());
	            }
	        }
	    }
	}
	public void editRequestBody(List<List<String>> data)
	{
		
		File xmlFile = new File(filename);
		int len = data.get(0).size();
		System.out.println(len);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		dbFactory.setNamespaceAware(true);
        DocumentBuilder dBuilder;
        Node sid=null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            NodeList root;// = doc.getDocumentElement();
            //prints root name space
            //printAttributesInfo((Node) root);
            
            XPath xPath = XPathFactory.newInstance().newXPath();
            //xPath.setNamespaceContext(new UniversalNamespaceResolver(doc));
            
            sid = (Node) xPath.evaluate("//*[local-name()='sessionId']",doc, XPathConstants.NODE);
            sid.setTextContent(sessionId);// set session id for api request
            System.out.println(sid.getNodeName());
            System.out.println(sid.getTextContent());
            Node pnode=null;
            for(int i=0;i<len;i++)
            {
            	System.out.println(data.get(0).get(i));
            	NodeList node = (NodeList) xPath.evaluate("//*[local-name()='"+data.get(0).get(i)+"']",doc, XPathConstants.NODESET);
            	//root = (NodeList) xPath.evaluate("//*[local-name()='"+data.get(0).get(i)+"']",doc, XPathConstants.NODESET);
            	System.out.println(node.item(0));
            	if(node.getLength()>1)
            	{
            		for(int j=0;j<node.getLength(); j++)
            		{
            			System.out.println(node.item(j).getNodeName());
                    	System.out.println(node.item(j).getTextContent());
                    	if(len>1)
                    	node.item(j).setTextContent(data.get(1).get(j));
                    	else
                    	node.item(j).setTextContent(data.get(1).get(i));
                        System.out.println(node.item(j).getTextContent());
            		}
            		
            	}
            	/*System.out.println(node.getParentNode());
                System.out.println(node.getTextContent());
                System.out.println(node.getPrefix());*/
            	else {
                if((data.get(0).get(i).equals("caseNum") || data.get(0).get(i).equals("caseNumber") ) && data.get(1).get(i).isEmpty())
                {
                	System.out.println(node.item(0).getNodeName());
                	System.out.println(node.item(0).getTextContent());
                	node.item(0).setTextContent(CaseNumber);
                	System.out.println(node.item(0).getTextContent());
                }
                else if(node== null)
                {
                	System.out.println(pnode.getNodeName());
                	String prefix = pnode.getPrefix();
                	Node newnode = doc.createElement(prefix+":"+data.get(0).get(i));
                	newnode.appendChild(doc.createTextNode(data.get(1).get(i)));
                	pnode.getParentNode().appendChild(newnode);
                }
                else if(data.get(0).get(i).equalsIgnoreCase("sessionid"))
                {
                    node.item(0).setTextContent(sessionId);
                }
                else {
                	System.out.println(node.item(0));
                	System.out.println(node.item(0).getNodeName());
                	System.out.println(node.item(0).getTextContent());
                	node.item(0).setTextContent(data.get(1).get(i));
                    System.out.println(node.item(0).getTextContent());
                }
                
                pnode = node.item(0);
            	}
            }
            
            
            doc.getDocumentElement().normalize();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filename));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            transformer.transform(source, result);
            System.out.println("XML file updated successfully");
            
        } catch (SAXException e1) {
            e1.printStackTrace();
        }
          catch(ParserConfigurationException e1) {
        	  e1.printStackTrace();
          }
          catch(TransformerException e1) {
        	  e1.printStackTrace();
          }
          catch(IOException e1) {
        	  e1.printStackTrace();
          } catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void submit() throws IOException
	{
		
		reqBody=generateStringFromResource(filename);
		setHeader("Content-Type","text/XML; charset=utf-8");
		headermap.put("SOAPAction", SOAPAction);
		headermap.put("Accept", "application/xml");
		
		if(requestType == "POST")
			response =  given().log().all().headers(headermap).body(reqBody).when().post(url).thenReturn();
		else if(requestType == "GET")
		{
			response = given().log().all().headers(headermap).body(reqBody).when().get(url).thenReturn();
		}
//		 xml = response.getBody().asString();
//		 xmlPath = new XmlPath(xml).using(XmlPathConfig.xmlPathConfig().namespaceAware(false)).setRootPath("soapenv:Envelope.soapenv:Body.createCaseResponse.result.");
	    responseBody=response.getBody().asString();

		
	}
	 public static Document toXmlDocument(String str) throws ParserConfigurationException, SAXException, IOException{
	        
         DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
         Document document = docBuilder.parse(new InputSource(new StringReader(str)));
        
         return document;
    }
	public static Document filetoXmlDocument(String filename) throws ParserConfigurationException, SAXException, IOException, TransformerException{
		
		File xmlFile = new File(filename);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		dbFactory.setNamespaceAware(true);
        DocumentBuilder dBuilder= dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        
        Transformer transformer;
		try {
			transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
	        DOMSource source = new DOMSource(doc);
	        StreamResult console = new StreamResult(System.out);
	        transformer.transform(source, console);
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return doc;
	 }
	 
	public List<List<String>> responseList(String fieldname, Document doc) throws IOException
	{
		List<List<String>> list1=new ArrayList<List<String>>();
		//List<String> list2;
		 try {
	            
	            XPath xPath = XPathFactory.newInstance().newXPath();
	            NodeList node = (NodeList) xPath.evaluate("//*[local-name()='"+fieldname+"']",doc, XPathConstants.NODESET);
	            	 System.out.println(node.getLength());
	            	 if(node.getLength()==0)
	            	 {
	            		 List<String> list2  = new ArrayList<String>();
	            		 list2.add("Result body is empty");
	            		 list1.add(list2);
	            		 
	            	 }
	            		for(int i=0;i<node.getLength();i++)
	            		{
	            			NodeList childnode =node.item(i).getChildNodes();
	            			List<String> list2  = new ArrayList<String>();
	            			int k=0;
	            			if(childnode.getLength()==0)
	            			{
	            				 list2  = new ArrayList<String>();
	            				list2.add(node.item(i).getTextContent());
	            			}
	            			else {
	            			for(int j=0;j<childnode.getLength();j++)
	            			{
	            				
	            				if(!(childnode.item(j).getTextContent().isEmpty()))
	            				{
	            					//System.out.print(childnode.item(j).getNodeName()+" ");
	            					list2.add(childnode.item(j).getNodeName()+" "+childnode.item(j).getTextContent());
	            					//System.out.print(Storage.getScenario().getName());
	            					//Storage.getScenario().write(childnode.item(j).getNodeName()+" ");
	            					//System.out.println(childnode.item(j).getTextContent());
	            					//Storage.getScenario().write(childnode.item(j).getTextContent());
	            					//System.out.println(list2.get(k));
	            					k++;
	            				}
	            				
	            				
	            			}
	            			}
	            			list1.add(list2);
	            			System.out.println();
	            		}
	            	}catch (XPathExpressionException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	            	}
		 return list1;
	
	}
	public String responseDetail(String fieldname, Document doc) throws IOException
	{
		  //xml =response.getBody().asString();
		  //System.out.println(xml);
	       
	       
	        Node node=null;
	        try {
	            
//	            Document doc = toXmlDocument(xml);
//	            Element root = doc.getDocumentElement();
	            XPath xPath = XPathFactory.newInstance().newXPath();
//	            for(int i=0;i<len;i++)
//	            {
	            	System.out.println(response.getBody().asString());
	            	System.out.println(doc);
	            	 node = (Node) xPath.evaluate("//*[local-name()='"+fieldname+"']",doc, XPathConstants.NODE);
	            	 
	            	 System.out.println(node.getNodeName());
	            	
	                if(node.getNodeName().equals("APICase:caseNumber"))
	                {
	                	CaseNumber=node.getTextContent();
	                	System.out.println(node.getNodeName());
	                	System.out.println(node.getTextContent());
	                	
	                }
	                else
	                {
	                	System.out.println(node.getNodeName());
		                System.out.println(node.getTextContent());
	                }
	            	 //node.setTextContent(data.get(1).get(i));
	               // System.out.println(node.getTextContent());
	            
	            //node.getTextContent();//.setTextContent(sessionId);// set session id for api request
//	        } catch (SAXException e1) {
//	            e1.printStackTrace();
//	        }
//	          catch(ParserConfigurationException e1) {
//	        	  e1.printStackTrace();
//	          }
//	         
//	          catch(IOException e1) {
//	        	  e1.printStackTrace();
	          } catch (XPathExpressionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return node.getTextContent();
	        
		 /* XPath xPath = XPathFactory.newInstance().newXPath();
		 xmlPath = new XmlPath(xml).using(XmlPathConfig.xmlPathConfig().namespaceAware(false)).setRootPath("soapenv:Envelope.soapenv:Body.createCaseResponse.result.");
	    
		System.out.println();
		System.out.println("API Status Code:"+response.getStatusCode());
		System.out.println("Account Number: "+xmlPath.getNode( xPath.evaluate("//*[local-name()='"+data.get(0).get(i)+"']",doc, XPathConstants.NODE)).getString("APICase:accountNumber"));     
		System.out.println("New Case Number: "+xmlPath.getString("APICase:caseNumber"));
		CaseNumber=xmlPath.getString("APICase:caseNumber") ;
		System.out.println("Product: "+xmlPath.getString("APICase:product"));
		System.out.println("version: "+xmlPath.getString("APICase:version"));
		System.out.println("status: "+xmlPath.getString("APICase:status"));
		System.out.println("owner: "+xmlPath.getString("APICase:owner"));
		System.out.println("origin: "+xmlPath.getString("APICase:origin"));
		System.out.println("contactName: "+xmlPath.getString("APICase:contactName"));
		System.out.println("description: "+xmlPath.getString("APICase:description"));*/
		
		
	}
}
