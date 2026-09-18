#include <iostream>
#include <string>
using namespace std;

// Base Class
class Vehicle
{
protected:
    string regNo;
    string owner;
    int year;
    double km;

public:
    Vehicle(string r, string o, int y, double k)
    {
        regNo = r;
        owner = o;
        year = y;
        km = k;
    }

    virtual double fuelCost(double distance) const = 0;

    virtual string vehicleType() const = 0;

    virtual void describe() const
    {
        cout << "Registration: " << regNo << endl;
        cout << "Owner: " << owner << endl;
        cout << "Year: " << year << endl;
        cout << "KM Driven: " << km << endl;
    }

    virtual ~Vehicle() {}
};


// Car
class Car : public Vehicle
{
    string fuelType;
    double mileage;

public:
    Car(string r, string o, int y, double k,
        string f, double m)
        : Vehicle(r, o, y, k)
    {
        fuelType = f;
        mileage = m;
    }

    double fuelCost(double distance) const override
    {
        double price;

        if (fuelType == "Petrol")
            price = 106;
        else
            price = 93;

        return (distance / mileage) * price;
    }

    string vehicleType() const override
    {
        return "Car";
    }
};


// Truck
class Truck : public Vehicle
{
protected:
    double payload;
    double efficiency;

public:
    Truck(string r, string o, int y, double k,
          double p, double e)
        : Vehicle(r, o, y, k)
    {
        payload = p;
        efficiency = e;
    }

    double fuelCost(double distance) const override
    {
        double actualEfficiency =
            efficiency * (1 - 0.05 * payload);

        return (distance / actualEfficiency) * 93;
    }

    string vehicleType() const override
    {
        return "Truck";
    }
};


// Electric Truck
class ElectricTruck : public Truck
{
    double battery;
    double range;

public:
    ElectricTruck(string r, string o, int y, double k,
                  double p, double e,
                  double b, double ra)
        : Truck(r, o, y, k, p, e)
    {
        battery = b;
        range = ra;
    }

    double fuelCost(double distance) const override
    {
        return (distance / range) * battery * 9.50;
    }

    string vehicleType() const override
    {
        return "Electric Truck";
    }
};


// Van
class Van : public Vehicle
{
    int seats;
    double mileage;

public:
    Van(string r, string o, int y, double k,
        int s, double m)
        : Vehicle(r, o, y, k)
    {
        seats = s;
        mileage = m;
    }

    double fuelCost(double distance) const override
    {
        return (distance / mileage) * 106;
    }

    string vehicleType() const override
    {
        return "Van";
    }
};


int main()
{
    Car c("C101", "Ramesh", 2022, 45000,
          "Petrol", 18);

    Truck t("T101", "Shyam", 2020, 80000,
            2, 6);

    ElectricTruck et("ET101", "Green Fleet", 2023,
                     50000, 2, 5, 500, 400);

    Van v("V101", "Amit", 2021, 60000,
          7, 15);

    cout << c.vehicleType() << endl;
    cout << t.vehicleType() << endl;
    cout << et.vehicleType() << endl;
    cout << v.vehicleType() << endl;

    return 0;
}