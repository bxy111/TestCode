package practice1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.*;

public class DomReader {
    public static void main(String[] args) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;

        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse("src\\practice1\\config.xml");

            Node node = doc.getFirstChild();
            Element root = (Element) node;

            NodeList childNodes = root.getChildNodes();
//            for (int i = 0; i < childNodes.getLength(); i++) {
//                Node item = childNodes.item(i);
//                NodeList childNodes1 = item.getChildNodes();
//                for (int j = 0; j < childNodes1.getLength(); j++) {
//                    Node item1 = childNodes1.item(j);
//                    System.out.println(item1.getNodeName());
//                    System.out.println(item1.getTextContent());
//                }
//            }

            String url = childNodes.item(0).getChildNodes().item(0).getTextContent();
            String user = childNodes.item(0).getChildNodes().item(1).getTextContent();
            String password = childNodes.item(0).getChildNodes().item(2).getTextContent();

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select color from petinfo where id=2");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
