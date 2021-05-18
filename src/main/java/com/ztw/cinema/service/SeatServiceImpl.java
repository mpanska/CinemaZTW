package com.ztw.cinema.service;

import com.ztw.cinema.entity.Seat;
import com.ztw.cinema.repo.SeatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

    private final SeatRepo seatRepo;

    @Autowired
    public SeatServiceImpl(SeatRepo seatRepo) {
        this.seatRepo = seatRepo;
    }

    @Override
    public List<Seat> findAll() {
        List<Seat> seats = new ArrayList<>();
        seatRepo.findAll().forEach(seats::add);
        return seats;
    }

    @Override
    public List<Seat> findAllByHallId(Long hallId) {
        List<Seat> seats = new ArrayList<>();
        seatRepo.findSeatByHallId(hallId).forEach(seats::add);
        return seats;
    }

    @Override
    public Seat findById(Long id) {
        return seatRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Seat not found: " + id));
    }

    @Override
    public Seat add(Seat seat) {
        seat.setId(0L);
        return seatRepo.save(seat);
    }

    @Override
    public Seat update(Seat seat) {
        Long id = seat.getId();
        if (!seatRepo.existsById(id))
            throw new RuntimeException("Seat not found: " + id);
        return seatRepo.save(seat);
    }

    @Override
    public void deleteById(Long id) {
        if (!seatRepo.existsById(id))
            throw new RuntimeException("Seat not found: " + id);
        seatRepo.deleteById(id);
    }
}
