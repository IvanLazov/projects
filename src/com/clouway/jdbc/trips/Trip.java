package com.clouway.jdbc.trips;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Trip {
    
    private String id;
    private String arrivalDate;
    private String departureDate;
    private String city;

    public Trip(String id, String arrivalDate, String departureDate, String city) {

        this.id = id;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.city = city;
    }

    public String getId() {

        return id;
    }

    public String getArrivalDate() {

        return arrivalDate;
    }

    public String getDepartureDate() {

        return departureDate;
    }

    public String getCity() {

        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trip trip = (Trip) o;

        if (arrivalDate != null ? !arrivalDate.equals(trip.arrivalDate) : trip.arrivalDate != null) return false;
        if (city != null ? !city.equals(trip.city) : trip.city != null) return false;
        if (departureDate != null ? !departureDate.equals(trip.departureDate) : trip.departureDate != null)
            return false;
        if (id != null ? !id.equals(trip.id) : trip.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (arrivalDate != null ? arrivalDate.hashCode() : 0);
        result = 31 * result + (departureDate != null ? departureDate.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}
