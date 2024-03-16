import java.util.*;

class Solution {
    // static final int baseMinute = 180;
    // static final int basePrice = 5000;
    // static final int unitMinute = 10;
    // static final int unitPrice = 600;
    
    public int[] solution(int[] fees, String[] records) {
        Map<String, Car> logs = new HashMap<>();
        for(String record : records){
            StringTokenizer st = new StringTokenizer(record);
            int timeInformation = convertMinute(st.nextToken()); // Corrected method name
            String carNumber = st.nextToken();
            String status = st.nextToken();

            remainLogs(logs, timeInformation, carNumber, status);
        }

        int defaultMinute = fees[0]; // Corrected variable name
        int defaultFee = fees[1];
        int unitMinute = fees[2];
        int unitFee = fees[3];

        List<String> carNumbers = new ArrayList<>(logs.keySet());
        Collections.sort(carNumbers);

        List<Integer> payments = new ArrayList<>();
        for (String carNumber : carNumbers){
            final String END_TIME = "23:59";
            Car car = logs.get(carNumber);
            int parkingMinute = car.getParkingMinute();

            if(!car.isStatus())
                parkingMinute += (convertMinute(END_TIME) - car.getEntranceTime());

            int fee = defaultFee;
            if (parkingMinute > defaultMinute) {
                fee += (int) Math.ceil((double) (parkingMinute - defaultMinute) / unitMinute) * unitFee;
            }
            payments.add(fee);
        }
        return payments.stream().mapToInt(Integer::intValue).toArray();
    }

    
   private static void remainLogs(Map<String, Car> logs, int timeInformation, String carNumber, String status){
    if(!logs.containsKey(carNumber)){
        logs.put(carNumber,new Car(carNumber,0,timeInformation, false));
    } else{
        //입차
        Car car = logs.get(carNumber);
        if(status.equals("IN")){
            logs.replace(carNumber, new Car(carNumber, car.getParkingMinute(), timeInformation, false));
        } else {
            int parkingMinute = car.getParkingMinute() + (timeInformation - car.getEntranceTime());
            logs.replace(carNumber, new Car(carNumber, parkingMinute, 0 , true));
        }
    }
   }
    
    private static int convertMinute(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        return hour * 60 + minute;
    }
    
    /**
    * 차량번호(string)
    * 주차시간(int)
    * 입차시간(int)
    * 입차/출차(boolean)
    */
    static class Car {
        private String carNumber;
        private int parkingMinute;
        private int entranceTime;
        private boolean status; 

        public Car(String carNumber, int parkingMinute, int entranceTime, boolean status) {
            this.carNumber = carNumber;
            this.parkingMinute = parkingMinute;
            this.entranceTime = entranceTime;
            this.status = status;
        }

        public String getCarNumber() {
            return carNumber;
        }

        public int getParkingMinute() {
            return parkingMinute;
        }

        public int getEntranceTime() {
            return entranceTime;
        }

        public boolean isStatus() {
            return status;
        }

    }

    
}




