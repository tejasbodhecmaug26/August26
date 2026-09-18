#include <iostream>
#include <string>
#include <stdexcept>
using namespace std;

class LedgerEntry
{
private:
    string description;
    double* amounts;
    int days;

public:

    LedgerEntry(const string& desc, int d)
    {
        description = desc;
        days = d;

        amounts = new double[days];

        for (int i = 0; i < days; i++)
            amounts[i] = 0;
    }

    // [] operator
    double& operator[](int index)
    {
        if (index < 0 || index >= days)
            throw out_of_range("Invalid index");

        return amounts[index];
    }

    ~LedgerEntry()
    {
        delete[] amounts;
    }
};

int main()
{
    LedgerEntry jan("January", 5);

    jan[0] = 1200.50;
    jan[1] = 3400.00;

    cout << jan[0] << endl;

    try
    {
        cout << jan[10] << endl;
    }
    catch (const out_of_range& e)
    {
        cout << e.what() << endl;
    }

    return 0;
}