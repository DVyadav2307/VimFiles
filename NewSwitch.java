public class NewSwitch{
	public static void main(String[] args){

		String day = "Sunday";

		String time = switch(day){
			case "Sunday", "Saturday" -> "11";
			case "Monday" -> "8";
			default -> "7";
		};
		System.out.println(time);
	}
}
