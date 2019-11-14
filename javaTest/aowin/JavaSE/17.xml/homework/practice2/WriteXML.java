package practice2;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteXML {
    public static void main(String[] args) {
        List<Pet> pets = PetDAO.listAll();

        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("pets");

        for (Pet p : pets) {
            Element pet = root.addElement("pet");
            Element name = pet.addElement("name");
            name.setText(p.getName());
            Element type = pet.addElement("type");
            type.setText(p.getType());
            Element color = pet.addElement("color");
            color.setText(p.getColor());
            Element price = pet.addElement("price");
            price.setText(String.valueOf(p.getPrice()));
        }

        OutputFormat prettyPrint = OutputFormat.createPrettyPrint();
        prettyPrint.setIndent(true);
        prettyPrint.setIndentSize(4);

        FileWriter fileWriter = null;
        XMLWriter xmlWriter = null;
        try {
            fileWriter = new FileWriter("src\\practice2\\data1.xml");
            xmlWriter = new XMLWriter(fileWriter, prettyPrint);
            xmlWriter.write(document);
            xmlWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (xmlWriter != null) {
                try {
                    xmlWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
