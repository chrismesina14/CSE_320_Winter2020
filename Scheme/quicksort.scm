(define (partition compare lst)
      (cond
         ((null? lst) '())
         ((compare (car lst)) (cons (car lst) (partition compare (cdr lst))))
         (else (partition compare (cdr lst)))))

   (define (quicksort lst)
      (cond
         ((null? lst) '())
         (else (let ((pivot (car lst)))
            (append (append (quicksort (partition (lambda (x) (< x pivot)) lst))
                       (partition (lambda (x) (= x pivot)) lst))
                    (quicksort (partition (lambda (x) (> x pivot)) lst)))))))
