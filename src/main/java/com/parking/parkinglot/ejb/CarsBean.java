package com.parking.parkinglot.ejb;

import com.parking.parkinglot.common.CarDto;
import com.parking.parkinglot.entities.Car;
import com.parking.parkinglot.entities.User;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import ro.ulbs.ingprog.parkinglot.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class CarsBean {
    private static final Logger LOG = Logger.getLogger(CarsBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public List<CarDto> findAllCars() {
        LOG.info("findAllCars");

        try {
            TypedQuery<Car> typedQuery = entityManager.createQuery("SELECT c FROM Car c", Car.class);
            List<Car> cars = typedQuery.getResultList();
            return copyCarsToDto(cars);
        } catch (Exception e) {
            throw new EJBException(e);
        }
    }

    private List<CarDto> copyCarsToDto(List<Car> cars) {
        List<CarDto> copiedCars = new ArrayList<>();

        for(Car c : cars) {
            copiedCars.add(carToDto(c));
        }

        return copiedCars;
    }

    private CarDto carToDto(Car c) {
        return new CarDto(
                c.getId(),
                c.getLicense_plate(),
                c.getParking_spot(),
                c.getOwner().getUsername()
        );
    }

    public void createCar(String licensePlate, String parkingSpot, Long userId) {
        LOG.info("createCar");

        Car car = new Car();
        car.setLicense_plate(licensePlate);
        car.setParking_spot(parkingSpot);

        User user = entityManager.find(User.class, userId);
        car.setOwner(user);
        user.getCars().add(car);

        entityManager.persist(car);
    }

    public void updateCar(Long carId, String licensePlate, String parkingSpot, Long userId) {
        LOG.info("updateCar");

        if(carId == null) {
            return;
        }

        User newOwner = entityManager.find(User.class, userId);
        Car car = entityManager.find(Car.class, carId);
        car.setLicense_plate(licensePlate);
        car.setParking_spot(parkingSpot);

        if(!newOwner.equals(car.getOwner())) {
            //car.getOwner().getCars().remove(car);
            car.setOwner(newOwner);
            newOwner.getCars().add(car);
        }
    }

    public CarDto findById(Long carId) {
        LOG.info("findById");

        Car car = entityManager.find(Car.class, carId);
        return carToDto(car);
    }

    public void deleteCarsByIds(List<Long> carIds) {
        LOG.info("deleteCarsByIds");

        for(Long carId : carIds) {
            deleteCarById(carId);
        }
    }

    private void deleteCarById(Long carId) {
        Car specifiedCar = entityManager.find(Car.class, carId);
        entityManager.remove(specifiedCar);
    }
}
