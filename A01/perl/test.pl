use 5.010;

$L = qr/([0-9]{1})((-([0-9]{1})){0, 1})/;

say "Enter a string to check: ";
chomp($input = <STDIN>);
# /^$L$/

if ($input =~ /^($L)$/) {
  say "Valid";
} else {
  say "Invalid";
}

# Check for book
if ($_[0] !~ /^((((\d ){1})?)([A-Za-z]+))/) {
  return 0;
}

# Remove book
$_[0] =~ s/^((((\d ){1})?)([A-Za-z]+))//;

# Remove translation (if any)
$_[0] =~ s/(( \(([A-Za-z]+)\))?)$//;

$L = qr/([0-9]{1})((-([0-9]{1})){0, 1})/
$V = qr/($L)+((,$L)*)/

# X = ([0-9]+)((:([0-9]{1})((-([0-9]{1})){0, 1})+((,([0-9]{1})((-([0-9]{1})){0, 1}))*))?)

return check_ref($_[0]);