import json

def readCycles():
    f = open('CyclicalTracker/cycles.json', "r")
    return json.loads(f.read())
    
print(readCycles())

# def readThisCycle(cycleName):
#     data = readCycles();
#     for name in data['Cycles']:
#         if name == cycleName:
#             return name 

# print(readThisCycle('Cycle'))