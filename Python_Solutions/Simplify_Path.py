"""
Leetcode Challenge: Simplify Path

Given an absolute path for a Unix-style file system, which begins with 
a slash '/', transform this path into its simplified canonical path.
In Unix-style file system context, a single period '.' signifies 
the current directory, a double period ".." denotes moving up one 
directory level, and multiple slashes such as "//" are interpreted as 
a single slash. In this problem, treat sequences of periods not covered 
by the previous rules (like "...") as valid names for files or directories.

The simplified canonical path should adhere to the following rules:
It must start with a single slash '/'.
Directories within the path should be separated by only one slash '/'.
It should not end with a slash '/', unless it's the root directory.
It should exclude any single or double periods used to denote 
current or parent directories.

Return the new path.

7/29/24
Mark Robuck
"""
class Solution:
    """
    Take a unix-stype path and apply formatting rules.
    Args: 
        path: original given path as a string
    Returns:
        str: formatted path as a string
    """
    def simplifyPath(self, path: str) -> str:
        #split the input by slashes to process
        components = path.split('/')

        stack = []

        for component in components:
            #ignore empty directories or current directory 
            if component == "" or component == ".":
                continue
            #move up one directory for double period
            if component == "..":
                #as long as stack is not empty
                if stack:
                    stack.pop()
            #add valid directory names to the stack
            else:
                stack.append(component)
        
        #merge the stack into a string after processed
        new_path = '/{}'.format('/'.join(stack))
        return new_path
