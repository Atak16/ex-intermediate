package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Central;
import com.example.repository.CentralRepository;

/**
 * 処理の流れを記述するServiceクラス
 * 
 * @author Akihide Takakahashi
 */
@Service
@Transactional
public class CentralService {
    @Autowired
    private CentralRepository repository;

    // 主キー検索
    public Central load(Integer id) {
        return repository.load(id);
    }

    // 全件検索
    public List<Central> findAll() {
        return repository.findAll();
    }
}