T-106.4200 Introduction to Compiling (5 cr)
Hannu Hartikainen


Compiler Assignment
===================

This is README for a compiler made using Coco/R that compiles a custom language
(generated for the assignment) to SLX assembly.


Documentation
-------------

The code is commented and should be quite readable. Javadoc-style comments
are used where useful. This README tries to give an overview of what was done
and why.


Features
--------

The compiler supports all language constructs in the "easy" grammar version.
The implementations primarily try to mimic how similar constructs work in most
other languages (say, C). With that in mind, the goal was to make the SLX code
as simple and short as possible.

Type checking and some other error checking was also implemented. The errors
in the "easy" grammar test set all get caught. The compiler uses SemErr to
notify about these, so the program is still compiled and may or may not work.
This is intentional.


Caveats
-------

The `return` keyword doesn't do anything useful. Its expression is evaluated
and pushed to stack, but other than that it's a no-op. As per grammar `return`
can only exist in the end of the main function, and it's also required there.


Implementation details
----------------------

ForStatement was renamed to Assignment for clarity.

### The for loop

The for loop works like in most languages, i.e. the loop is like

    for(a;b;c)
      d;

and execution flows like

        a;
    test:
        if (b) goto loop;
        else goto end;
    incr:
        c;
        goto test;
    loop:
        d;
        goto incr;
    end:

Note that to get d; to run before c; we need to be jumping around all the time!
It would have been easier to just let c; run in the beginning of the loop, but
that's not what programmers are used to.


Workload
--------

About 30 hours total were used for the project. This was due to real-life
constraints; it would have been preferable to allocate a little more time.
