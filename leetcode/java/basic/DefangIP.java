/**
Given a valid (IPv4) IP address, return a defanged version of that IP address.

A defanged IP address replaces every period "." with "[.]".
  **/
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
