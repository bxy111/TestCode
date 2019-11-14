package practice1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DomWriter {
    public static void main(String[] args) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        File file = null;
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            //添加节点
            Element databases = document.createElement("databases");
            document.appendChild(databases);
            Element database = document.createElement("database");
            databases.appendChild(database);
            Element url = document.createElement("url");
            url.setTextContent("jdbc:mysql://127.0.0.1:3306/bxytest?characterEncoding=UTF-8&useSSL=false");
            database.appendChild(url);
            Element user = document.createElement("user");
            user.setTextContent("root");
            database.appendChild(user);
            Element password = document.createElement("password");
            password.setTextContent("123456");
            database.appendChild(password);

            //写入xml文件
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            Source source = new DOMSource(document);
            file = new File("src\\practice1\\config.xml");
            StreamResult streamResult = new StreamResult(file);
            transformer.transform(source, streamResult);

        } catch (ParserConfigurationException | TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
