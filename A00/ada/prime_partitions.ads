with Ada.Text_IO; use Ada.Text_IO;
with Ada.Numerics; use Ada.Numerics;
with Ada.Numerics.Elementary_Functions; use Ada.Numerics.Elementary_Functions;
with Ada.Containers.Vectors;

procedure Prime_Partitions is
  package Natural_List is new
    Ada.Containers.Vectors
      (Index_Type => Natural,
      Element_Type => Natural);
  
  package Partition_List is new
    Ada.Containers.Vectors
      (Index_Type => Natural,
      Element_Type => Natural_List.Vector,
      "=" => Natural_List."=");

  -- Check if a number is prime
  function Is_Prime (K : Integer) return Boolean is
  begin
    if K < 2 then
      return False;
    end if;
    
    for I in 2 .. Integer(Sqrt(Float(K))) loop
      if K mod I = 0 then
        return False;
      end if;
    end loop;
    
    return True;
  end Is_Prime;

  -- Get all the primes in between A and B
  function Get_Primes (A, B : Integer) return Natural_List.Vector is
    Primes : Natural_List.Vector;
  begin
    for I in A .. B loop
      if Is_Prime(I) then
        Primes.Append(I);
      end if;
    end loop;
    
    return Primes;
  end Get_Primes;

  -- Get all the prime partitions of K where every element is at least Lower_Bound
  function Get_Prime_Partitions (K : Integer; Lower_Bound : Integer := 2) return Partition_List.Vector is
    Partitions : Partition_List.Vector;
    Sub_Partitions : Partition_List.Vector;
    Primes : Natural_List.Vector := Get_Primes(Lower_Bound, K);
  begin
    if K < 2 then
      return Partitions;
    end if;

    for P of Primes loop
      if P = K then
        declare
          New_Partition : Natural_List.Vector;
        begin
          New_Partition.Append(P);
          Partitions.Append(New_Partition);
        end;
      else
        Sub_Partitions := Get_Prime_Partitions(K - P, P + 1);

        for Partition of Sub_Partitions loop
          declare
            New_Partition : Natural_List.Vector;
          begin
            
            New_Partition.Append(P);
            
            for E of Partition loop
              New_Partition.Append(E);
            end loop;

            Partitions.Append(New_Partition);
          end;
        end loop;
      end if;
    end loop;

    return Partitions;
  end Get_Prime_Partitions;

  function To_String (K : Natural) return String is
  begin
    return K'Image (2 .. K'Image'Last);
  end To_String;

  procedure Print_Prime_Partitions (K : Integer) is
    Partitions : Partition_List.Vector := Get_Prime_Partitions(K);
  begin
    for Partition of Partitions loop
      Put(To_String(K) & " = ");

      for P of Partition loop
        Put (To_String(P));

        if P /= Partition.Last_Element then
          Put (" + ");
        end if;
      end loop;

      Put_Line (" (" & To_String(Natural(Partition.Length)) & ")");
    end loop;

    Put_Line (To_String(K) & " has " & To_String(Natural(Partitions.Length)) & " prime partitions");
  end Print_Prime_Partitions;
begin
  Print_Prime_Partitions(20);
end Prime_Partitions;