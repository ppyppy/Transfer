bool isUnique1(string s)
{
    bool a[256];
    memset(a, 0, sizeof(a));
    int len = s.length();
    for(int i=0; i < len; ++i)
    {
        int v = (int)s[i];
        if(a[v]) return false;
        a[v] = true;
    }
    return true;
}

bool isUnique2(string s)
{
    int a[8];
    memset(a, 0, sizeof(a));
    int len = s.length();
    for(int i=0; i < len; ++i)
    {
        int v = (int)s[i];
        int idx = v/32, shift=v%32;
        if(a[idx] & (1 << shift)) return false;
        a[idx] |= (1 << shift);
    }
    return true;
}

//如果字符集只是a－z(或是A－Z)，那就更好办了，用位运算只需要一个整型数即可。

bool isUnique3(string s)
{
    int check = 0;
    int len = s.length();
    for(int i=0; i < len; ++i)
    {
        int v = (int)(s[i]-'a');
        if(check & (1 << v)) return false;
        check |= (1 << v);
    }
    return true;
}