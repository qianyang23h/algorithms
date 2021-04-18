# 
# 1) Insert, delete, random access of array
# 



class MyArray:
    def __init__(self, capacity):
        """
        capacity: array capacity
        """
        self._data = []
        self._capacity = capacity

    def __getitem__(self, index):
        return self._data[index]
    
    def __setitem__(self, index, value):
        self._data[index] = value

    def __len__(self):
        return len(self._data)

    def __iter__(self):
        for item in self._data:
            yield item

    def insert(self, index, value):
        if len(self) >= self._capacity:
            return False
        else:
            return self._data.insert(index, value)
    
    def delete(self, index):
        try:
            self._data.pop(index)
            return True
        except IndexError:
            return False
    
    def find(self, index):
        try:
            return self._data[index]
        except IndexError:
            return None

    def print_all(self):
        for item in self:
            print(item)
    

def test_myarray():
    array = MyArray(5)
    array.insert(0,5)
    array.insert(0,2)
    array.insert(0,0)
    array.print_all()

if __name__ == "__main__":
    test_myarray()
