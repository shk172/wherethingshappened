package wherethingshappened;

public class Feed {
	String Title;
	String Description;
	String PublishedDate;
	String Link;
	
	public void setTitle(String Title){
		this.Title = Title;
	}
	public String getTitle(){
		return this.Title;
	}
	
	public void setDescription(String Description){
		this.Description = Description;
	}
	public String getDescription(){
		return this.Description;
	}
	
	public void setPublishedDate(String PublishedDate){
		this.PublishedDate = PublishedDate;
	}
	public String getPublishedDate(){
		return this.PublishedDate;
	}
	
	public void setLink(String Link){
		this.Link = Link;
	}
	public String getLink(){
		return this.Link;
	}
}
