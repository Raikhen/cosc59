with Ada.Text_IO; use Ada.Text_IO;

procedure PrimePartitions is
  N : constant := 20;
  Big_Number : constant := 10000;
  
  type Prime_List is array (2 .. N) of Boolean;
  
  function Get_Primes return Prime_List is
    Prime : Prime_List := (others => True);
  begin
    for P in Prime'Range loop
      if Prime (P) then
        for N in 2 .. Positive'Last loop
          exit when N * P not in Prime'Range;
          Prime (N * P) := False;
        end loop;
      end if;
    end loop;
    
    return Prime;
  end Get_Primes;

  type Partition_List is array (1 .. Big_Number) of Prime_List;
  
  type Partition_List_With_Size is record
    List : Partition_List;
    Size : Integer range 1 .. Big_Number;
  end record;

  function Get_Prime_Partitions return Partition_List is
    n : Natural;
    Number_Of_Partitions : Natural := 0;
    Partitions : Partition_List := (others => (others => False));
    Subpartitions_With_Size : Partition_List_With_Size;
    Subpartitions : Partition_List;
    Prime : constant Prime_List := Get_Primes;
  begin
    if n < 2 then
      return Partitions;
    end if;
    
    for p in Prime'Range loop
      if n = p then
        partitions (Number_Of_Partitions) (n) := True;
        Number_Of_Partitions := Number_Of_Partitions + 1;
      end if;
      
      Subpartitions_With_Size := Get_Prime_Partitions(n - p, p + 1);
      Subpartitions := Subpartitions_With_Size.List;
      
    end loop;
    
    return Partitions;
  end Get_Prime_Partitions;
  
  -- Prime : constant Prime_List := Get_Primes;
  -- V : Boolean;
begin
  -- for i in Prime'Range loop
  --   V := Prime (I);
  --   Put_Line (V'Image);
  -- end loop;
  Put_Line("Hey!");
end PrimePartitions;