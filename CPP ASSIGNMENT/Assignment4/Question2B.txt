#include <iostream>
#include <string>
using namespace std;


// Base Class
class Vehicle
{
protected:
    string regNo;

public:

    Vehicle(string r)
    {
        regNo = r;
        cout << "Vehicle Constructor: " << regNo << endl;
    }

    virtual ~Vehicle()
    {
        cout << "Vehicle Destructor: " << regNo << endl;
    }
};


// Truck inherits Vehicle
class Truck : public Vehicle
{
public:

    Truck(string r) : Vehicle(r)
    {
        cout << "Truck Constructor: " << regNo << endl;
    }

    ~Truck()
    {
        cout << "Truck Destructor: " << regNo << endl;
    }
};


// ElectricTruck inherits Truck
class ElectricTruck : public Truck
{
public:

    ElectricTruck(string r) : Truck(r)
    {
        cout << "ElectricTruck Constructor: "
             << regNo << endl;
    }

    ~ElectricTruck()
    {
        cout << "ElectricTruck Destructor: "
             << regNo << endl;
    }
};


int main()
{
    ElectricTruck e("ET001");

    cout << "Scope is ending..." << endl;

    return 0;
}