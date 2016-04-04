package csRpg;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Entity {

		Image sprite;
		
		public Entity(String location) throws SlickException {
			sprite = new Image(location);
		}
		
		public Image getSprite()
		{
			return sprite;
		}
}
