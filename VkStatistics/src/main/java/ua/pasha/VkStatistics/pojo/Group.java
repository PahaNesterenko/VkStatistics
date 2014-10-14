package ua.pasha.VkStatistics.pojo;

/**
 * Class container for VK Group. Contains main info about some Group.
 * @author Pasha
 */
public class Group {
	
	private int gid;
	private String name;
	private String screenName;
	private boolean isClosed;
	private String type;
	private String city;
	private String country;
	private String place;
	private String wikiPage;
	private String description;
	private int membersCount;
	private String startDate;
	private String finishDate;
	private String activity;
	private String status;
	private int verified;
	private String site;
	private String photoAddress;

	
	
	public String getPhotoAddress() {
		return photoAddress;
	}
	public void setPhotoAddress(String photoAddress) {
		this.photoAddress = photoAddress;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public boolean isClosed() {
		return isClosed;
	}
	public void setClosed(boolean isClosed) {
		this.isClosed = isClosed;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getMembersCount() {
		return membersCount;
	}
	public void setMembersCount(int membersCount) {
		this.membersCount = membersCount;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getWikiPage() {
		return wikiPage;
	}
	public void setWikiPage(String wikiPage) {
		this.wikiPage = wikiPage;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getVerified() {
		return verified;
	}
	public void setVerified(int verified) {
		this.verified = verified;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	
	public String toString(){
		
		return "group id " + gid + ", name - " + name + "\n"
				+ "city - " + city + "\n"
				+ "description - " + description + "\n"
				+ "members - " + membersCount + ", status - " + status;
		
	}
	

}
