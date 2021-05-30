package com.ztw.cinema;

import com.ztw.cinema.entity.Seat;
import com.ztw.cinema.repo.HallRepo;
import com.ztw.cinema.repo.SeatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private final SeatRepo seatRepo;
    private final HallRepo hallRepo;
    private static String[] alphabet = { "a", "b", "c", "d", "e", "f", "g",
            "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y", "z" };

    @Autowired
    public DataLoader(SeatRepo seatRepo, HallRepo hallRepo) {
        this.seatRepo = seatRepo;
        this.hallRepo = hallRepo;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        for (int i = 0; i < 15; ++i)
//            for (int j = 1, k = 1; j <= 10; ++j, ++k) {
//                if (k == 4 || k == 9)
//                    ++k;
//                Seat seat = new Seat();
//                seat.setRow(alphabet[i]);
//                seat.setNumber(j);
//                seat.setPosition(k);
//                seat.setHall(hallRepo.findById(1L).orElseThrow(RuntimeException::new));
//                seatRepo.save(seat);
//            }
//
//        for (int i = 0; i < 9; ++i)
//            for (int j = 1, k = 1; j <= 10; ++j, ++k) {
//                if (k == 4 || k == 9)
//                    ++k;
//                Seat seat = new Seat();
//                seat.setRow(alphabet[i]);
//                seat.setNumber(j);
//                seat.setPosition(k);
//                seat.setHall(hallRepo.findById(2L).orElseThrow(RuntimeException::new));
//                seatRepo.save(seat);
//            }
    }
}
