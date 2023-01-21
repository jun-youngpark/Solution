package jdk8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamGroupingBy {

    class BookState{
        private LocalDate toDate;
        private String channel;

        public BookState(LocalDate toDate, String channel) {
            this.toDate = toDate;
            this.channel = channel;
        }

        public LocalDate getToDate() {
            return toDate;
        }

        public void setToDate(LocalDate toDate) {
            this.toDate = toDate;
        }

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }
    }
    public static void main(String[] args) {
        StreamGroupingBy test = new StreamGroupingBy();

        test.test();
    }

    public void test(){
        List<BookState> dates = new ArrayList<>();
        dates.add(new BookState(LocalDate.of(2022,12,22), "M"));
        dates.add(new BookState(LocalDate.of(2022,12,22), "S"));
        dates.add(new BookState(LocalDate.of(2022,12,22), "T"));
        dates.add(new BookState(LocalDate.of(2022,12,23), "T"));
        dates.add(new BookState(LocalDate.of(2022,12,24), "T"));
        dates.add(new BookState(LocalDate.of(2022,12,25), "A"));
        dates.add(new BookState(LocalDate.of(2022,12,23), "A"));

        // 원하는 결과 ( 2022-12-22,"M","S","T")
        // 원하는 결과 ( 2022-12-23,"T")
        for (BookState bookState:dates) {


        }
        Map<LocalDate, List<BookState>> collect = dates.stream().collect(Collectors.groupingBy(BookState::getToDate));


        System.out.println(dates.stream()
                .filter(list -> list.getToDate().equals(LocalDate.of(2022,12,27)))
                .map(BookState::getChannel)
                .collect(Collectors.joining(",")));


    }

}
