package q1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SocialMediaContext socialMedia = new SocialMediaContext();
		socialMedia.setSocialmediaConnecion(new Facebook());
		socialMedia.connect();
		socialMedia.setSocialmediaConnecion(new Twitter());
		socialMedia.connect();
		socialMedia.setSocialmediaConnecion(new GooglePlus());
		socialMedia.connect();
		socialMedia.setSocialmediaConnecion(new Orkut());
		socialMedia.connect();

	}

}
