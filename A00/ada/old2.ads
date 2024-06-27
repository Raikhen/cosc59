with Ada.Text_IO; use Ada.Text_IO;

procedure PrimePartitions is
  N : constant := 5;
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
    Partitions : Partition_List := (others => (others => False));
  begin
    Partitions (1) (2) := True;
    Partitions (1) (3) := True;
    return Partitions;
  end Get_Prime_Partitions;
  
  function Sum_Partition (Partition : Prime_List) return Integer is
    Total : Integer range 0 .. N := 0;
  begin
    for i in Partition'Range loop
      if Partition (i) then
        Total := Total + i;
      end if;
    end loop;
    
    return Total;
  end Sum_Partition;
  
  procedure Print_Prime_Partitions is
    Partitions : Partition_List := Get_Prime_Partitions;
    i : Integer range 1 .. Big_Number;
  begin
    for i in Partitions'Range loop
      exit when Sum_Partition (Partitions (i)) = 0;
      Put (N'Image);
      Put (" = ");
      
      for j in 2 .. N loop
        if Partitions (i) (j) then
          Put (j'Image);
          Put (" + ");
        end if;
      end loop;
    end loop;
  end Print_Prime_Partitions;
begin
  Print_Prime_Partitions;
end PrimePartitions;