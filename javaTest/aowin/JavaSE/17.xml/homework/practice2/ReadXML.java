package practice2;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadXML {
    public static void main(String[] args) {
        SAXReader saxReader = new SAXReader();
        Document read = null;
        ArrayList<Pet> pets = new ArrayList<>();

        try {
            read = saxReader.read(new File("src\\practice2\\data.xml"));
            Element rootElement = read.getRootElement();

            Iterator<Element> elementIterator = rootElement.elementIterator();
            outWhile: while (elementIterator.hasNext()) {
                Pet pet = new Pet();
                Element next = elementIterator.next();
                List<Element> elements = next.elements();
                for (Element e : elements) {
                    if ("name".equals(e.getName())) {
                        pet.setName(e.getText());
                    } else if ("type".equals(e.getName())) {
                        pet.setType(e.getText());
                    } else if ("color".equals(e.getName())) {
                        pet.setColor(e.getText());
                    } else if ("price".equals(e.getName())) {
                        try {
                            pet.setPrice(Double.parseDouble(e.getText()));
                        } catch (NumberFormatException ex) {
                            ex.printStackTrace();
                            continue outWhile;
                        }
                    }
                }
                pets.add(pet);
            }

            PetDAO.insertPet(pets);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }
}
