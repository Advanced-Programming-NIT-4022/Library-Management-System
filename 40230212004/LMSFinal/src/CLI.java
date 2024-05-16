public class CLI extends Commands {
    public void start() {

        boolean stay = true;
        do {
            int currentID = enter();
            int wayPoint = currentID / 1000;
            switch (wayPoint) {
                case 1:
                    adminUserClearance(currentID);
                    break;
                case 2:
                    normalUserClearance(currentID);
                    break;
                case 3:
                    break;
                default:
                    stay = false;
                    break;
            }
        }while(stay);
    }
}
