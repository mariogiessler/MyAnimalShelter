package Control;
import View.UserWindow;

public class Controller {
    private static UserWindow window;

    public static void main(String[] args) {
        window = new UserWindow();
    }
    public static void changeView() {
		window.setCenterForm();
		window.validate();
		window.repaint();
	}

	public static void setFramePosition(int startDistanceX,int startDistanceY,int mousePositionX,int mousePositionY){
          window.setLocation((int) (mousePositionX - startDistanceX), (int) (mousePositionY - startDistanceY));
	}

	public static UserWindow getFrame(){
		return window;
	}
}
