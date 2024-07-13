use 5.010;

sub check {
  $N = qr/[a-zA-Z]+/;
  $D = qr/[0-9]+/;
  $T = qr/( \($N\)){0, 1}/;
  $L = qr/$D|$D-$D/;
  $V = qr/$L(,$L)*/;
  $C = qr/$D/;
  $X = qr/$C|($C:$V)/;
  $R = qr/( $X((;$X))*)?/;
  $B = qr/($D ){0, 1}$N/;
  $S = qr/$B$R$T/;

  return $_[0] =~ /^$S$/;
}

open(FH, "../test.txt") or die "There was an error opening the file.";

while (<FH>) {
  print $_;

  if (!((substr $_, -1) =~ /\n/)) {
    say "";
  }

  if (check($_)) {
    print "Valid\n\n";
  } else {
    print "Invalid\n\n";
  }
}

close;