public class Driver {
    public static void main(String[] args) {
        UI ui = new UI();
//Initialize Eren with 50 energy
        Eren e = new Eren(50, ui);
//Initialize Eren with 20 patience
        TeamLeader Levi = new TeamLeader("Levi Ackerman",20,ui,e);
//Initialize Friends
        Friend Mikasa = new Friend("Mikasa",ui,e);
        Friend Armin = new Friend("Armin",ui,e);
//Initialize Titans
        Titan Armor = new Titan("Armored Titan",ui,e);
        Titan Colossal = new Titan("Colossal Titan",ui,e);
    }}
