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

    // Move Assignment
    LedgerEntry& operator=(LedgerEntry&& other) noexcept
    {
        if (this != &other)
        {
            delete[] amounts;

            description = move(other.description);

            amounts = other.amounts;
            days = other.days;

            other.amounts = nullptr;
            other.days = 0;

            cout << "Move Assignment Called" << endl;
        }

        return *this;
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
    LedgerEntry feb("February", 3);

    feb[0] = 500;

    LedgerEntry q1("Q1 Total", 3);

    q1 = move(feb);

    cout << "Q1 first amount: " << q1[0] << endl;

    return 0;
}