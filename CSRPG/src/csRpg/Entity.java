package csRpg;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Entity implements java.io.Serializable {

		String location;
		
		public Entity(String location) throws SlickException {
			this.location = location;
		}
		
		public Image getSprite() throws SlickException	{
			return new Image(location);
		}
}
