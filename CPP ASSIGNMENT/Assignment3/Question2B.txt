#include <iostream>
#include <memory>
#include <string>
using namespace std;

class Shader
{
private:
    string name;
    string type;

public:
    Shader(string n, string t)
    {
        name = n;
        type = t;

        cout << "[Shader Compiled]" << endl;
    }

    ~Shader()
    {
        cout << "[Shader Destroyed]" << endl;
    }
};

int main()
{
  
    auto shader = make_shared<Shader>("main_vert", "vertex");

    cout << "Ref count: " << shader.use_count() << endl;   // 1

    {
       
        auto rendererRef = shader;

        cout << "Ref count: " << shader.use_count() << endl;   // 2

  
        auto editorRef = shader;

        cout << "Ref count: " << shader.use_count() << endl;   // 3
    }

 
    cout << "Ref count: " << shader.use_count() << endl;   // 1

    return 0;
}