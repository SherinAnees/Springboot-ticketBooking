package com.learning.SpringRestTicketBookingApp.service;

import com.learning.SpringRestTicketBookingApp.dao.ITouristRepo;
import com.learning.SpringRestTicketBookingApp.exception.TouristNotFoundException;
import com.learning.SpringRestTicketBookingApp.model.Tourist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TouristMangmentImplementation implements ITouristManagment{

   @Autowired
    private ITouristRepo repo;

    @Override
    public String registerTourist(Tourist tourist) {
        Tourist tour=repo.save(tourist);
        return "Tourist registered with id : "+ tour.getTid();

    }

    @Override
    public List<Tourist> getAllTourists() {
        return repo.findAll();
    }

    @Override
    public Tourist fetchTouristById(Integer id) {
//        Optional<Tourist> optional=repo.findById(id);
//        if (optional.isPresent())
//        {
//            return optional.get();
//        }else {
//            return new TouristNotFoundException("Tourist with id" +id+ "Not Founde");
//        }
           return repo.findById(id).orElseThrow(()->new TouristNotFoundException("Tourist not found "+ id));

    }

    @Override
    public String updateTheTouristAllDetails(Tourist tourist) {
       Optional<Tourist> optional= repo.findById(tourist.getTid());
        if (optional.isPresent())
        {
           repo.save(tourist);
           return "Tourist with id"+tourist.getTid()+"is updated";
       }else
           return " Not found";
    }

    @Override
    public String updateTouristById(Integer id, Double budgetHike) {
        Optional<Tourist> optional=repo.findById(id);
        if(optional.isPresent())
        {
            Tourist tourist=optional.get();
            tourist.setBudget(tourist.getBudget()+(tourist.getBudget()*budgetHike/100));
            repo.save(tourist);
            return "Tourist updated";
        }
        else
        {
            throw new TouristNotFoundException("Tourist not found");
        }
    }


}
