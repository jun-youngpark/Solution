package level2;

public class 택배배달수거 {

    public static void main(String[] args) {

        택배배달수거 main = new 택배배달수거();
        int cap =4;
        int n =5;
        int[] deliveries = {1, 0, 3, 1, 2};
        int[] pickups ={0, 3, 0, 4, 0};
        main.solution(cap,n,deliveries,pickups);

    }

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        Home[] homes = new Home[n];
        Truck truck = new Truck();
        truck.load(cap);

        for(int i=0;i<n;i++){
            homes[i] = new Home();
            homes[i].distance = i +1;
            homes[i].numberOfDeliveries = deliveries[i];
            homes[i].numberOfCollection = pickups[i];
        }

        int current = 0;
        for(int j=n-1;j>0;j--){
            System.out.println("이동거리"+homes[j].distance);
            answer  += homes[j].distance - current;
            current = homes[j].distance;
            System.out.println(answer);
            while(homes[j].isComplete()) {
                if (homes[j].isDeliver()) {
                    homes[j].numberOfDeliveries--;
                }
                if (homes[j].isCollect()) {
                    homes[j].numberOfDeliveries--;
                }
                if (truck.isMax()) {
                    answer  += homes[j].distance *2;
                    truck.load(cap);
                }
            }
        }
        System.out.println(answer);
        return answer;
    }



    class Box{
        public boolean blank;

    }

    class Truck{

        int box;
        int max;
        int currentBoxLength;

        public Truck(){


        }
        public boolean isMax(){
            return max>=box;
        }


        public void load(int cnt){
           this.box = cnt;
           this.max = cnt;
        }


        public void deliver(int index){
             box --;
        }

        public void collect(int index){
            box ++;
        }

    }

    class Home{

        private int distance;
        private int numberOfDeliveries;
        private int numberOfCollection;
        private boolean complete;

        public Home(int distance, int numberOfDeliveries,int numberOfCollection){
            this.distance = distance;
            this.numberOfDeliveries = numberOfDeliveries;
            this.numberOfCollection = numberOfCollection;
        }

        public Home() {

        }

        public boolean isComplete(){
            return numberOfDeliveries == 0 && numberOfCollection ==0;
        }
        public boolean isDeliver(){
            return numberOfDeliveries > 0;
        }
        public boolean isCollect(){
            return numberOfCollection > 0;
        }
    }

}
