package com.ztw.cinema.service;

import com.ztw.cinema.dto.ShowDetailsDto;

public interface ShowDetailsService {

    ShowDetailsDto findById(Long id);
}
