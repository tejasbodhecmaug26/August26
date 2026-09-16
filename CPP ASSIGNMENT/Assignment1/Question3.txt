#include <iostream>
using namespace std;

int main()
{
    double temp[3][3];

    
    cout << "Enter temperature of 9 rooms:" << endl;

    for(int i = 0; i < 3; i++)
    {
        cout << "Floor " << i + 1 << ":" << endl;

        for(int j = 0; j < 3; j++)
        {
            cout << "Room " << j + 1 << ": ";
            cin >> temp[i][j];
        }
    }

    
    cout << "\nTemperature Table:" << endl;

    for(int i = 0; i < 3; i++)
    {
        cout << "Floor " << i + 1 << ": ";

        for(int j = 0; j < 3; j++)
        {
            cout << temp[i][j] << "  ";
        }

        cout << endl;
    }


    double hottest = temp[0][0];
    int hotFloor = 0;
    int hotRoom = 0;

    
    int warning = 0;

    for(int i = 0; i < 3; i++)
    {
        for(int j = 0; j < 3; j++)
        {
            if(temp[i][j] > hottest)
            {
                hottest = temp[i][j];
                hotFloor = i;
                hotRoom = j;
            }

            if(temp[i][j] >= 30)
            {
                warning++;
            }
        }
    }

    
    double highestAverage = 0;
    int highestFloor = 0;

    for(int i = 0; i < 3; i++)
    {
        double sum = 0;

        for(int j = 0; j < 3; j++)
        {
            sum = sum + temp[i][j];
        }

        double average = sum / 3;

        if(average > highestAverage)
        {
            highestAverage = average;
            highestFloor = i;
        }
    }

    cout << "\nHottest Room: " << hottest << " C";
    cout << " (Floor " << hotFloor + 1;
    cout << ", Room " << hotRoom + 1 << ")" << endl;

    cout << "Floor with highest average: Floor "
         << highestFloor + 1 << endl;

    cout << "Highest average temperature: "
         << highestAverage << " C" << endl;

    cout << "Rooms at or above WARNING (30 C): "
         << warning << endl;

    return 0;
}