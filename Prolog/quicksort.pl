qsort([], []).
qsort([H|T], Sorted) :-
	partition(H, T, Less, Greater),
	qsort(Less, SortedLess),
	qsort(Greater, SortedGreater),
	append(SortedLess, [H|SortedGreater], Sorted).

partition(_, [], [], []).
partition(P, [H|T], [H|Less], Greater) :- 
	H =< P,
	partition(P, T, Less, Greater). 
partition(P, [H|T], Less, [H|Greater]) :-  
	H > P,
	partition(P, T, Less, Greater).
