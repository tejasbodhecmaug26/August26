#include <iostream>
#include <string>
using namespace std;

class Product
{
private:
    int productId;
    string name;
    double price;
    int quantity;

public:
    void acceptDetails()
    {
        cin >> productId >> name >> price >> quantity;
    }

    void displayDetails() const
    {
        cout << productId << " "
             << name << " "
             << price << " "
             << quantity << endl;
    }

    double totalValue() const
    {
        return price * quantity;
    }

    bool isLowStock(int threshold) const
    {
        return quantity < threshold;
    }
};


double reorderCost(int qty, double price)
{
    return qty * price;
}

double reorderCost(double qty, double price)
{
    return qty * price;
}

double reorderCost(int qty, double price, double tax)
{
    double cost = qty * price;
    return cost + (cost * tax / 100);
}


double applyDiscount(double price, double discount = 10.0)
{
    return price - (price * discount / 100);
}

int main()
{
    Product products[5];

    
    for(int i = 0; i < 5; i++)
    {
        products[i].acceptDetails();
    }

    
    for(int i = 0; i < 5; i++)
    {
        products[i].displayDetails();
    }

    
    int highest = 0;

    for(int i = 1; i < 5; i++)
    {
        if(products[i].totalValue() > products[highest].totalValue())
        {
            highest = i;
        }
    }

    cout << "Highest Value Product: ";
    products[highest].displayDetails();

    
    int threshold;
    cin >> threshold;

    for(int i = 0; i < 5; i++)
    {
        if(products[i].isLowStock(threshold))
        {
            products[i].displayDetails();
        }
    }


    cout << reorderCost(10, 50.0) << endl;
    cout << reorderCost(10.5, 50.0) << endl;
    cout << reorderCost(10, 50.0, 18.0) << endl;

    
    cout << applyDiscount(1000) << endl;
    cout << applyDiscount(1000, 20) << endl;

    return 0;
}