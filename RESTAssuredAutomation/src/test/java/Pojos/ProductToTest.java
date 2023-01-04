package Pojos;

import org.apache.juneau.html.HtmlSerializer;
import org.apache.juneau.json.JsonParser;
import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.xml.XmlSerializer;
import org.yaml.snakeyaml.serializer.SerializerException;
//org.apache.juneau
public class ProductToTest {
  //poojo to json
	public static void main(String[] args) throws SerializerException {
		JsonSerializer jsonserializer=JsonSerializer.DEFAULT_READABLE;
		String sellernames[]= {"Neon entrprice, ABC Software, XYZ company"};
		Product product=new Product("MAckbook",1000,"white",sellernames);	
		String json=jsonserializer.serialize(product);
		System.out.println(json);
		//pojoto xml
		XmlSerializer xmlSerializer	=XmlSerializer.DEFAULT_NS_SQ_READABLE;
		String XML=xmlSerializer.serialize(product);
		System.out.println(XML);
		
		//poojo to HTMl
		HtmlSerializer htmlSerializer=HtmlSerializer.DEFAULT_SQ_READABLE;
		String HTML=htmlSerializer.serialize(product);
		System.out.println(HTML);
		
		//de serilization
		JsonParser jsonParser=JsonParser.DEFAULT;
		String JsonVal="{\r\n"
				+ "	\"color\": \"white\",\r\n"
				+ "	\"name\": \"MAckbook\",\r\n"
				+ "	\"price\": 1000,\r\n"
				+ "	\"sellernames\": [\r\n"
				+ "		\"Neon entrprice, ABC Software, XYZ company\"\r\n"
				+ "	]\r\n"
				+ "}";
	Product pro=jsonParser.parse(JsonVal, Product.class);
				
				System.out.println(pro.getColor());
				System.out.println(pro);
				
				
	}

}
