import sys
import logging

def compare(m,n):
    return m > n
def add(m,n):
    return m + n
def sub(m,n):
    return m - n 


def main():
    if len(sys.argv) > 2:
        
        func_name = sys.argv[1]
        print(f"System Args recieved mode:{func_name}")
        args = list(map(lambda x : float(x),sys.argv[2:]))
        try:
            
            match(func_name):
                case "add":
                    sum = add( args[0], args[1])
                    print(f"The sum is: {sum}")
                case "sub":
                    diff = sub(args[0],args[1])
                    print(f"The diff is: {diff} ")
                case "comp":
                    lg, sm = args[0],args[1]
                    result = compare(lg,sm)                  
                    if result == False:
                        lg = lg+sm
                        sm = lg - sm
                        lg = lg - sm
                    print(f"{lg} is greater than{sm}")
        except Exception as e:
            print(f"Error {e}")
    else:
        print('Args requirement not met')
    
if __name__ == "__main__":
    main()
