#include <iostream>
using namespace std;

int main()
{
    double C;
    int statusCode;

    cout << "Enter temperature: ";
    cin >> C;

    
    if (C < 0)
        statusCode = -1;
    else if (C <= 29)
        statusCode = 0;
    else if (C <= 44)
        statusCode = 1;
    else if (C <= 59)
        statusCode = 2;
    else
        statusCode = 3;

    
    double F = (C * 9 / 5) + 32;

    cout << "Temperature : " << C << "°C / "
         << F << "°F" << endl;

    
    switch (statusCode)
    {
        case -1:
            cout << "Status      : SENSOR_ERROR" << endl;
            cout << "Action      : Sensor fault - check wiring" << endl;
            break;

        case 0:
            cout << "Status      : NORMAL" << endl;
            cout << "Action      : No action required" << endl;
            break;

        case 1:
            cout << "Status      : WARNING" << endl;
            cout << "Action      : Alert sent to supervisor" << endl;
            break;

        case 2:
            cout << "Status      : CRITICAL" << endl;
            cout << "Action      : Cooling system triggered" << endl;
            break;

        case 3:
            cout << "Status      : SHUTDOWN" << endl;
            cout << "Action      : Emergency shutdown initiated" << endl;
            break;
    }


    cout << "Reading     : "
         << (C >= 25 ? "Above Average" : "Below Average")
         << endl;

    return 0;
}