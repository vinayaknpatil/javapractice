import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;

public class UrlLibrary implements Iterable<String> {

	private LinkedList<String> urls = new LinkedList<String>();
	
	// Inner class to get the iterator 
	private class UrlIterator implements Iterator<String>
	{
		private int index = 0;

		public boolean hasNext() {
			return index < urls.size();
		}

		public String next() {
			StringBuilder sb = new StringBuilder();
			// TODO Auto-generated method stub
			try {
				URL url = new URL(urls.get(index));
				
				BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
				
				
				
				String str = null;
				
				while( ( str = br.readLine() ) != null)
				{
					sb.append(str);
					sb.append("\n");
				}
				
				br.close();
				
			} catch (Exception ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
			finally
			{
				
			}
			index ++;
			return sb.toString();
		}

		public void remove() {
			// TODO Auto-generated method stub
			urls.remove(index);
		}
		
		
		
	}
	
	public UrlLibrary()
	{
		urls.add("http://www.google.com");
		urls.add("https://www.twitter.com");
		urls.add("https://www.facebook.com");
		
	}

	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return new UrlIterator();
	}

	/*
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return urls.iterator();
	}
	*/
}
