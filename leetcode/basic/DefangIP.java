public class DefangIP {
	
	public static void main(String [] args)
	{
		DefangIP ip = new DefangIP();
		
		System.out.println(ip.defangIPaddr("255.100.50.0"));
	}
	
public String defangIPaddr(String address) {
	
		if(address == null || address.trim().length() == 0)
			return "";
		
		
		return address.replaceAll("\\.", "[.]");
        
    }

}
