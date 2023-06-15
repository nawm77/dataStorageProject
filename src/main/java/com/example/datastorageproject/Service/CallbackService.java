package com.example.datastorageproject.Service;

import com.example.datastorageproject.Model.Callback;
import com.example.datastorageproject.Repository.CallbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CallbackService {
    private final CallbackRepository callbackRepository;

    @Autowired
    public CallbackService(CallbackRepository callbackRepository) {
        this.callbackRepository = callbackRepository;
    }
    public void saveCallback(Callback callback){
        callbackRepository.save(callback);
    }
    public List<Callback> getAllCallback(){
        return callbackRepository.findAll();
    }
    public void deleteCallback(Integer id){
        callbackRepository.deleteById(id);
    }
}
