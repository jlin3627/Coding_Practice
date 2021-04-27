#include <iostream>


class Node
{
    public:
        Node(){val = 0;}
        Node(int t){val = t;}
        int val;
        Node* next;
};

class doubleNode
{
    public:
        doubleNode(){val = 0;}
        doubleNode(int t){val = t;}
        int val;
        doubleNode* next;
        doubleNode* prev;
};

int main()
{
    Node* test = new Node(1);
    Node test2(3);
    Node* test3 = new Node(4);
    
    std::cout<<test->val<<std::endl;
    test->val = 2;
    std::cout<<test->val<<std::endl;
    std::cout<<test2.val<<std::endl;
    test->next = &test2;
    std::cout<<test->next->val<<std::endl;
    test->next->next = test3;
    std::cout<<test->next->next->val<<std::endl;

    doubleNode* dn = new doubleNode(0);
    dn->next = new doubleNode(1);
    dn->prev = new doubleNode(-1);
    std::cout<<"test"<<std::endl;
    std::cout<<dn->prev->val<<" "<<dn->val<<" "<<dn->next->val<<std::endl;
    return 0;
}