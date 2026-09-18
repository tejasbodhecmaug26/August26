#include <iostream>
#include <vector>
using namespace std;

class Vehicle
{
protected:
    string regNo;

public:
    Vehicle(string r)
    {
        regNo = r;
    }

    virtual double fuelCost(double km) = 0;
    virtual string vehicleType() = 0;

    string getRegNo()
    {
        return regNo;
    }

    virtual ~Vehicle() {}
};


class Car : public Vehicle
{
public:
    Car(string r) : Vehicle(r) {}

    double fuelCost(double km)
    {
        return km * 5;
    }

    string vehicleType()
    {
        return "Car";
    }
};


class Truck : public Vehicle
{
public:
    Truck(string r) : Vehicle(r) {}

    double fuelCost(double km)
    {
        return km * 8;
    }

    string vehicleType()
    {
        return "Truck";
    }
};


class ElectricTruck : public Truck
{
public:
    ElectricTruck(string r) : Truck(r) {}

    double fuelCost(double km)
    {
        return km * 2;
    }

    string vehicleType()
    {
        return "Electric Truck";
    }

    void battery()
    {
        cout << "Battery: 85%" << endl;
    }
};


class Van : public Vehicle
{
public:
    Van(string r) : Vehicle(r) {}

    double fuelCost(double km)
    {
        return km * 6;
    }

    string vehicleType()
    {
        return "Van";
    }
};


void printFleetReport(vector<Vehicle*>& fleet, double km)
{
    double minCost = 999999;
    Vehicle* best = nullptr;

    for (Vehicle* v : fleet)
    {
        double cost = v->fuelCost(km);

        cout << v->getRegNo()
             << "  "
             << v->vehicleType()
             << "  Rs." << cost << endl;

        if (cost < minCost)
        {
            minCost = cost;
            best = v;
        }

        // Check Electric Truck
        ElectricTruck* e =
            dynamic_cast<ElectricTruck*>(v);

        if (e != nullptr)
            e->battery();
    }

    cout << endl;

    cout << "Most Efficient: "
         << best->getRegNo()
         << "  Rs." << minCost << endl;
}


int main()
{
    vector<Vehicle*> fleet;

    fleet.push_back(new Car("C101"));
    fleet.push_back(new Truck("T101"));
    fleet.push_back(new ElectricTruck("ET101"));
    fleet.push_back(new Van("V101"));

    printFleetReport(fleet, 200);

    for (Vehicle* v : fleet)
        delete v;

    return 0;
}