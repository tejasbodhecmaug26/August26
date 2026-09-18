#include <iostream>
#include <string>
#include <utility>
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

    // Move Constructor
    LedgerEntry(LedgerEntry&& other) noexcept
    {
        description = move(other.description);

        amounts = other.amounts;
        days = other.days;

        // Make source empty
        other.amounts = nullptr;
        other.days = 0;

        cout << "Move Constructor Called" << endl;
    }

    double& operator[](int index)
    {
        return amounts[index];
    }

    ~LedgerEntry()
    {
        delete[] amounts;
    }
};

int main()
{
    LedgerEntry jan("January Sales", 3);

    jan[0] = 100;
    jan[1] = 200;
    jan[2] = 300;

    LedgerEntry moved = move(jan);

    cout << "Moved first amount: " << moved[0] << endl;

    return 0;
}